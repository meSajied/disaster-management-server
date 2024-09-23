package org.disastermanagement.users;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
class UserService {
  private final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  Optional<AppUser> findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  AppUser createUser(AppUser user) {
    return userRepository.save(user);
  }

  Optional<AppUser> updateUser(AppUser user) {
    return userRepository.findByUsername(user.getUsername()).map(existingData -> {
      return updateData(existingData, user);
    });
  }

  private AppUser updateData(AppUser existingData, AppUser newData) {
    existingData.setName(newData.getName());
    existingData.setPassword(newData.getPassword());
    existingData.setPhone(newData.getPhone());
    existingData.setAge(newData.getAge());
    existingData.setTask(newData.getTask());

    return userRepository.save(existingData);
  }

  List<AppUser> getAllUsers() {
    return (List<AppUser>) userRepository.findAll();
  }
}
