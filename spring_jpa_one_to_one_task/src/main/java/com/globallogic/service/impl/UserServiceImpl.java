package com.globallogic.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.AddressDto;
import com.globallogic.dto.UserDto;
import com.globallogic.entity.Address;
import com.globallogic.entity.User;
import com.globallogic.repository.UserRepository;
import com.globallogic.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * @Description : To get all UserDTOs
	 * @Returns : It returns List of ProductDTOs
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 03/11/2022
	 */
	@Override
	public List<UserDto> getAllUsers() {

		return userRepository.findAll().stream().map(user -> convertToDto(user)).collect(Collectors.toList());
	}


	/*
	 * @Description : To add User into database
	 * @Returns : It returns UserDTO which has been added
	 * @Params : It takes UserDTO as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 03/11/2022
	 */
	@Override
	public UserDto addUser(UserDto userDto) {

		return convertToDto(userRepository.save(converToEntity(userDto)));
	}

	/*
	 * @Description : To get User by using his id
	 * @Returns : It returns UserDTO
	 * @Params : It takes User ID as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 03/11/2022
	 */
	@Override
	public UserDto getUserById(long id) {

		return convertToDto(userRepository.findById(id).get());
	}

	/*
	 * @Description : To update User by using his id
	 * @Returns : It returns Updated UserDTO
	 * @Params : It takes User ID and UserDTO as parameters
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 03/11/2022
	 */
	@Override
	public UserDto updateUserById(long id, UserDto userDto) {

		User user = userRepository.findById(id).get();

		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		Address address = new Address();

		address.setId(userDto.getAddressDto().getId());
		address.setStreet(userDto.getAddressDto().getStreet());
		address.setCity(userDto.getAddressDto().getCity());
		address.setZipCode(userDto.getAddressDto().getZipCode());
		address.setState(userDto.getAddressDto().getState());
		address.setCountry(userDto.getAddressDto().getCountry());

		address.setUser(user);
		user.setAddress(address);

		return convertToDto(userRepository.save(user));
	}

	/*
	 * @Description : To delete User by using his id
	 * @Params : It takes User ID as parameter
	 * @createdBy : Kiran Kumar G S
	 * @CreatedDate : 03/11/2022
	 */

	@Override
	public void deleteUserById(long id) {

		userRepository.delete(userRepository.findById(id).get());

	}

	/*
	 * It Converts User Entity to User DTO
	 */
	private UserDto convertToDto(User user) {

		AddressDto addressDto = new AddressDto();

		addressDto.setId(user.getAddress().getId());
		addressDto.setStreet(user.getAddress().getStreet());
		addressDto.setCity(user.getAddress().getCity());
		addressDto.setZipCode(user.getAddress().getZipCode());
		addressDto.setState(user.getAddress().getState());
		addressDto.setCountry(user.getAddress().getCountry());

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAddressDto(addressDto);

		return userDto;
	}

	/*
	 * It Converts User DTO to User Entity
	 */
	private User converToEntity(UserDto userDto) {

		Address address = new Address();
		User user = new User();

		address.setId(userDto.getAddressDto().getId());
		address.setStreet(userDto.getAddressDto().getStreet());
		address.setCity(userDto.getAddressDto().getCity());
		address.setZipCode(userDto.getAddressDto().getZipCode());
		address.setState(userDto.getAddressDto().getState());
		address.setCountry(userDto.getAddressDto().getCountry());

		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAddress(address);

		// bidirectional Mapping
		address.setUser(user);

		return user;
	}

}
