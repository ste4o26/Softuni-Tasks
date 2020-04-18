package user_permissions.repositories;

import user_permissions.resources.Resource;

public abstract class ResourceRepositoryImpl implements ResourceRepository{
    private int size;

    public ResourceRepositoryImpl(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public abstract Resource fetchOne();
}
