package tech.buildrun.agregadorinvestimentos.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.buildrun.agregadorinvestimentos.controller.CreateUserDto;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<UUID> uuidCaptor;

    @Nested
    @DisplayName("createUser")
    class CreateUserTests {

        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateAUserWithSuccess() {
            // arrange
            UUID fakeId = UUID.randomUUID();
            User savedUser = new User(
                    fakeId,
                    "username",
                    "email@exemplo.com",
                    "password",
                    Instant.now(),
                    null
            );
            when(userRepository.save(any(User.class)))
                    .thenReturn(savedUser);

            CreateUserDto input = new CreateUserDto(
                    "username",
                    "email@exemplo.com",
                    "123"
            );

            // act
            UUID result = userService.createUser(input);

            // assert
            assertNotNull(result);
            assertEquals(fakeId, result);
        }
    }

    @Nested
    @DisplayName("getUserById")
    class GetUserByIdTests {

        @Test
        @DisplayName("Should get user by id with success")
        void shouldGetByIdWithSuccess() {
            // arrange
            UUID fakeId = UUID.randomUUID();
            User user = new User(
                    fakeId,
                    "username",
                    "email@exemplo.com",
                    "password",
                    Instant.now(),
                    null
            );
            doReturn(Optional.of(user))
                    .when(userRepository)
                    .findById(uuidCaptor.capture());

            // act
            Optional<User> output = userService.getUserById(fakeId.toString());

            // assert
            assertTrue(output.isPresent());
            assertEquals(fakeId, uuidCaptor.getValue());
        }
    }

    @Nested
    @DisplayName("listUsers")
    class ListUsersTests {

        @Test
        @DisplayName("Should return all users with success")
        void shouldReturnAllUsersWithSuccess() {
            // arrange
            UUID fakeId = UUID.randomUUID();
            User user = new User(
                    fakeId,
                    "username",
                    "email@exemplo.com",
                    "password",
                    Instant.now(),
                    null
            );
            List<User> userList = List.of(user);
            when(userRepository.findAll())
                    .thenReturn(userList);

            // act
            List<User> output = userService.listUsers();

            // assert
            assertNotNull(output);
            assertEquals(userList.size(), output.size());
            assertEquals(userList, output);
        }
    }

    @Nested
    @DisplayName("deleteById")
    class DeleteByIdTests {

        @Test
        @DisplayName("Should delete user with success")
        void shouldDeleteUserWithSuccess() {
            // arrange
            UUID fakeId = UUID.randomUUID();

            doReturn(true)
                    .when(userRepository)
                    .existsById(uuidCaptor.capture());

            doNothing()
                    .when(userRepository)
                    .deleteById(uuidCaptor.capture());

            // act
            userService.deleteById(fakeId.toString());

            // assert
            var capturedIds = uuidCaptor.getAllValues();
            assertEquals(2, capturedIds.size());
            assertEquals(fakeId, capturedIds.get(0)); // existsById
            assertEquals(fakeId, capturedIds.get(1)); // deleteById

            verify(userRepository, times(1)).existsById(capturedIds.get(0));
            verify(userRepository, times(1)).deleteById(capturedIds.get(1));


        }
    }

}