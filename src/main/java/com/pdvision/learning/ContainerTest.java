package com.pdvision.learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ContainerTest
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.pdvision.learning");//This will load the configured components UserService, UserRepository,
        ctx.refresh();

        System.out.println(ctx);
        UserService userService = ctx.getBean("userService", UserService.class);

        List<Client> allClient = userService.getAllUsers();
        for (Client u : allClient)
        {
            System.out.println(u);
        }

        Client client = new Client(null, "K.siva reddy", "hyderabad");
        Integer id = userService.createUser(client);
        System.out.println("Newly created User Id="+id);
        allClient = userService.getAllUsers();
        for (Client u : allClient)
        {
            System.out.println(u);
        }
    }

}