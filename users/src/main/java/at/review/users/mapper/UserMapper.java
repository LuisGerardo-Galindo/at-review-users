package at.review.users.mapper;

import org.springframework.stereotype.Component;

import at.review.users.dto.UserDTO;
import at.review.users.dto.UserResponse;
import at.review.users.model.User;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class UserMapper implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(User.class, User.class).mapNulls(false).byDefault().register();
		orikaMapperFactory.classMap(User.class, UserDTO.class).mapNulls(false).byDefault().register();
		orikaMapperFactory.classMap(UserDTO.class, User.class).mapNulls(false).byDefault().register();
		orikaMapperFactory.classMap(User.class, UserResponse.class).mapNulls(false).byDefault().register();
	}
}
