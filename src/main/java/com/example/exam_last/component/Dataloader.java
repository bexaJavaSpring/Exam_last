package com.example.exam_last.component;

import com.example.exam_last.entity.Category;
import com.example.exam_last.entity.Product;
import com.example.exam_last.entity.Role;
import com.example.exam_last.entity.User;
import com.example.exam_last.entity.enums.PermissionEnum;
import com.example.exam_last.entity.enums.RoleEnum;
import com.example.exam_last.repository.CategoryRepository;
import com.example.exam_last.repository.ProductRepository;
import com.example.exam_last.repository.RoleRepository;
import com.example.exam_last.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    private String mode;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final CategoryRepository categoryRepository;
    final ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always") && ddl.equals("create")) {
            Role admin1 = new Role();
            admin1.setName(RoleEnum.ADMIN1);
            admin1.setPermissionEnumSet(Arrays.stream(PermissionEnum.values()).collect(Collectors.toSet()));

            Role admin2 = new Role();
            admin2.setName(RoleEnum.ADMIN2);
            admin2.setPermissionEnumSet(new HashSet<>(Arrays.asList(
                    PermissionEnum.ADD_PRODUCT
            )));
            Role user=new Role();
            user.setName(RoleEnum.USER);
            user.setPermissionEnumSet(new HashSet<>(Arrays.asList(
                    PermissionEnum.READ_ALL_PRODUCT
            )));
            roleRepository.save(admin1);
            roleRepository.save(admin2);
            roleRepository.save(user);

            Category category = new Category();
            category.setName("Laptoplar");
            categoryRepository.save(category);

            Product product=new Product();
            product.setName("Apple");
            product.setPrice(12000d);
            product.setAmount(2000d);
            productRepository.save(product);

            Set<Role> roles = new HashSet<>();
            roles.add(admin1);
            roles.add(admin2);
            roles.add(user);

            Set<Role> rol=new HashSet<>();
            rol.add(admin2);
            rol.add(user);

            Set<Role> rollll=new HashSet<>();
            rollll.add(user);

            User user1 = new User("Bexruz Izzatullayev", roles, "Bekhruz", "0000",true);
            userRepository.save(user1);
            User user2=new User("Jafarbek To'rayev",rol,"Jafar","1111",true);
            userRepository.save(user2);
            User user3=new User("Jamshid",rollll,"Jamik","2222",true);
            userRepository.save(user3);
        }
    }
}
