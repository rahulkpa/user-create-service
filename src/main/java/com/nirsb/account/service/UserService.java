package com.nirsb.account.service;

import com.nirsb.account.configuration.Sender;
import com.nirsb.account.dao.UserDAO;
import com.nirsb.account.exception.UserNotFoundException;
import com.nirsb.account.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private Sender sender;

	private static String USER_CREATED_TOPIC= "USER_CREATED_TOPICS";

    private static Mapper mapper = new DozerBeanMapper();

	@Autowired
	UserDAO userDao;

	
	public com.nirsb.account.model.dto.User createUser(User user) {
		
		com.nirsb.account.model.dto.User userObject =  
		    mapper.map(user, com.nirsb.account.model.dto.User.class);
		List<com.nirsb.account.model.dto.Address> addressDtoObject = new ArrayList<com.nirsb.account.model.dto.Address>();
		List<com.nirsb.account.model.Address> addressList = user.getAddresses();
		if(addressList != null) {
			for(com.nirsb.account.model.Address address: addressList) {
				addressDtoObject.add(mappingAddress(address));
			}
			userObject.setAddresses(addressDtoObject);
		}
		com.nirsb.account.model.dto.User newUserObject = userDao.save(userObject);
		/*if( newUserObject != null) {
			sender.send(USER_CREATED_TOPIC, user);
			return newUserObject;
		}*/
		return newUserObject;
	}
	
	private com.nirsb.account.model.dto.Address mappingAddress(com.nirsb.account.model.Address address){
		com.nirsb.account.model.dto.Address addressObject = 
				mapper.map(address,com.nirsb.account.model.dto.Address.class);
		return addressObject;
	}

	private com.nirsb.account.model.Address mappingAddressInternalToExternal(com.nirsb.account.model.dto.Address address){
		com.nirsb.account.model.Address addressObject =
				mapper.map(address,com.nirsb.account.model.Address.class);
		return addressObject;
	}
	
	public com.nirsb.account.model.User getUser(long id){
		com.nirsb.account.model.dto.User user = null;
		com.nirsb.account.model.User userObject = null;
		try {
			user = userDao.getOne(id);
		if (user.getFirstName() == null) {
			throw new UserNotFoundException("User Not Found in DB: " + id);
		}
		userObject =
				mapper.map(user, com.nirsb.account.model.User.class);
		List<com.nirsb.account.model.Address> addressDtoObject = new ArrayList<com.nirsb.account.model.Address>();
		List<com.nirsb.account.model.dto.Address> addressList = user.getAddresses();
		if(addressList != null) {
			for(com.nirsb.account.model.dto.Address address: addressList) {
				addressDtoObject.add(mappingAddressInternalToExternal(address));
			}
			userObject.setAddresses(addressDtoObject);
		}
		}catch (EntityNotFoundException e){
			throw new UserNotFoundException("User Not Found in DB: " + id);
		}

		return userObject;
	}

	public List<com.nirsb.account.model.User> getUsers(){
		com.nirsb.account.model.User userObject = null;
		List<com.nirsb.account.model.User> finalResult = new ArrayList<>();
		try {
			List<com.nirsb.account.model.dto.User> users = userDao.findAll();
			for(com.nirsb.account.model.dto.User user: users) {
				userObject =
						mapper.map(user, com.nirsb.account.model.User.class);
				List<com.nirsb.account.model.Address> addressDtoObject = new ArrayList<com.nirsb.account.model.Address>();
				List<com.nirsb.account.model.dto.Address> addressList = user.getAddresses();
				if (addressList != null) {
					for (com.nirsb.account.model.dto.Address address : addressList) {
						addressDtoObject.add(mappingAddressInternalToExternal(address));
					}
					userObject.setAddresses(addressDtoObject);
				}
				finalResult.add(userObject);
			}
		}catch (EntityNotFoundException e){
			throw new UserNotFoundException("No Record Found in DB");
		}

		return finalResult;
	}

	public void deleteUser(long userId){
		userDao.deleteById(userId);
	}
	
}
