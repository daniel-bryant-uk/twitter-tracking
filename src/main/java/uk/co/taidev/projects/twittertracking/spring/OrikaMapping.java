package uk.co.taidev.projects.twittertracking.spring;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import uk.co.taidev.projects.twittertracking.models.User;
import uk.co.taidev.projects.twittertracking.rest.model.UserView;

@Component
public class OrikaMapping extends ConfigurableMapper {

    @Override
    protected void configure(final MapperFactory factory) {
        factory.classMap(UserView.class, User.class).byDefault().register();
    }

}