package com.epam.jwd.servlet.command;

public interface RequestContext {

    void setAttribute(String name, Object obj);
    Object getAttribute(String name);
    void invalidateSession();
    void setSessionAttribute(String name, Object value);

}
