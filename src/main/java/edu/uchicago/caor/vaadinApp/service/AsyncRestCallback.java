package edu.uchicago.caor.vaadinApp.service;

@FunctionalInterface
public interface AsyncRestCallback<T> {
    void operationFinished(T results);
}
