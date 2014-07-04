package com.example.helloworld.health;

//import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheck;
import com.example.helloworld.core.Template;
import com.google.common.base.Optional;

//public class TemplateHealthCheck extends HealthCheck {
//    private final Template template;
//
//    public TemplateHealthCheck(Template template) {
//        this.template = template;
//    }
//
//    @Override
//    protected Result check() throws Exception {
//        template.render(Optional.of("woo"));
//        template.render(Optional.<String>absent());
//        return Result.healthy();
//    }
//}

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.hubspot.dropwizard.guice.InjectableHealthCheck;

@Singleton
public class TemplateHealthCheck extends InjectableHealthCheck {

    private final Template template;

    @Inject
    public TemplateHealthCheck(Template template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        template.render(Optional.of("woo"));
        template.render(Optional.<String>absent());
        return Result.healthy();
    }

    @Override
    public String getName() {
        return "template";
    }
}
