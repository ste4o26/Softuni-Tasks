package user_permissions.repositories;

import user_permissions.resources.Resource;
import user_permissions.resources.Video;

public class VideoRepository extends ResourceRepositoryImpl {
    public VideoRepository(int size) {
        super(size);
    }

    @Override
    public Resource fetchOne() {
        return new Video(super.getSize());
    }
}
