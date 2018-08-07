package com.example.demo2.configuration;

import io.swagger.annotations.ApiModel;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.schema.DefaultTypeNameProvider;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.Optional;

import static com.google.common.base.Strings.emptyToNull;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER - 1)
public class SwaggerApiModelTypeNameProvider extends DefaultTypeNameProvider {
    @Override
    public String nameFor(Class<?> type) {
        final ApiModel annotation = findAnnotation(type, ApiModel.class);
        final String defaultTypeName = type.getName();
        if (annotation != null) {
            return Optional.ofNullable(emptyToNull(annotation.value())).orElse(defaultTypeName);
        }
        return defaultTypeName;
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return SwaggerPluginSupport.pluginDoesApply(delimiter);
    }
}
