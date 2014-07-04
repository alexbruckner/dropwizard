package com.example.helloworld;

import javax.inject.Named;

import com.example.helloworld.core.Template;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.hibernate.SessionFactory;

public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    @Named("template")
    public Template provideTemplate(HelloWorldConfiguration configuration) {
        return configuration.buildTemplate();
    }

    @Provides
    @Named("defaultName")
    public String provideDefaultName(HelloWorldConfiguration configuration) {
        return configuration.getDefaultName();
    }

    @Provides
    public SessionFactory provideSessionFactory(HelloWorldConfiguration configuration) {
       return configuration.getSessionFactory();
    }



}