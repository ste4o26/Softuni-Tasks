package user_permissions.repositories;

import user_permissions.resources.File;
import user_permissions.resources.Resource;

public class FileRepository extends ResourceRepositoryImpl{

    public FileRepository(int size) {
        super(size);
    }

    @Override
    public Resource fetchOne() {
        return new File(super.getSize());
    }
}
