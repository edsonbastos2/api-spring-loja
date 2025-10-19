package com.ecommerce.service;

import com.ecommerce.controller.dto.CreateUserDto;
import com.ecommerce.entities.BillingAddressEntity;
import com.ecommerce.entities.UserEntity;
import com.ecommerce.repository.BillingAddressRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {
        var billingAddres = new BillingAddressEntity();
        billingAddres.setAddress(dto.address());
        billingAddres.setNumber(dto.number());
        billingAddres.setComplement(dto.complement());

        var savedBillingAddress = billingAddressRepository.save(billingAddres);

        var user = new UserEntity();

        user.setFullName(dto.fullName());
        user.setBillingAddressEntity(savedBillingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(UUID userId) {
        return userRepository.findById(userId);
    }
}
