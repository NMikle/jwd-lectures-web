package com.epam.jwd.servlet.pool;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.ArrayBlockingQueue;

public enum ConnectionPool {
    INSTANCE;

    private static final int INITIAL_CONNECTIONS_AMOUNT = 8;

    private final ArrayBlockingQueue<ProxyConnection> connections = new ArrayBlockingQueue<>(INITIAL_CONNECTIONS_AMOUNT);

    public Connection retrieveConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public void returnConnection(Connection connection) {
        //todo: check connection on fake
        try {
            connections.put((ProxyConnection) connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public void init() throws SQLException, InterruptedException {
        //todo: database initialization procedures
        registerDrivers();
        for (int i = 0; i < INITIAL_CONNECTIONS_AMOUNT; i++) {
            final Connection realConnection = DriverManager.getConnection("jdbc:mysql://localhost:1234/testDb", "root", "root");
            final ProxyConnection proxyConnection = new ProxyConnection(realConnection);
            connections.put(proxyConnection);
        }
    }

    public void destroy() {
        //todo: connection destroy procedures
        connections.forEach(ProxyConnection::closeConnection); //real close
        deregisterDrivers();
    }


    private static void registerDrivers() {
        System.out.println("registering another drivers");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(DriverManager.getDriver("jdbc:mysql://localhost:1234/testDb"));
            System.out.println("registration successful");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("deregistering successful");
            e.printStackTrace();
        }
    }


    private static void deregisterDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (SQLException e) {
                System.out.println("deregistration unsuccessful");
                e.printStackTrace();
            }
        }
    }
}
