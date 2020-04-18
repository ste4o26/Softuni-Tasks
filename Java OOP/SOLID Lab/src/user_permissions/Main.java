package user_permissions;

import user_permissions.repositories.*;
import user_permissions.users.Admin;
import user_permissions.users.RegularUser;
import user_permissions.users.User;

public class Main {
    public static void main(String[] args) {
        User admin = new Admin();
        User regularUser = new RegularUser();

        ResourceRepository pictureRepository = new PictureRepository(20);
        UserService service = new UserService(pictureRepository);
        service.readOneResourceForUser(admin);
        service.readOneResourceForUser(regularUser);
        System.out.println();


        ResourceRepository fileRepository = new FileRepository(15);
        service = new UserService(fileRepository);
        service.readOneResourceForUser(admin);
        service.readOneResourceForUser(regularUser);
        System.out.println();


        ResourceRepository musicRepository = new MusicRepository(25);
        service = new UserService(musicRepository);
        service.readOneResourceForUser(admin);
        service.readOneResourceForUser(regularUser);
        System.out.println();


        ResourceRepository videoRepository = new VideoRepository(30);
        service = new UserService(videoRepository);
        service.readOneResourceForUser(admin);
        service.readOneResourceForUser(regularUser);

    }
}
