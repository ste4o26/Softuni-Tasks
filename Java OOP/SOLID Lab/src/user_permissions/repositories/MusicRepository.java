package user_permissions.repositories;

import user_permissions.resources.Music;
import user_permissions.resources.Resource;

public class MusicRepository extends ResourceRepositoryImpl {

    public MusicRepository(int size) {
        super(size);
    }

    @Override
    public Resource fetchOne() {
        return new Music(super.getSize());
    }
}
