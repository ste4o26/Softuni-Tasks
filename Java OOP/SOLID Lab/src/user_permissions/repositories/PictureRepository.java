package user_permissions.repositories;

import user_permissions.resources.Picture;
import user_permissions.resources.Resource;

public class PictureRepository extends ResourceRepositoryImpl {

    public PictureRepository(int size) {
        super(size);
    }

    @Override
    public Resource fetchOne() {
        return new Picture(super.getSize());
    }
}
