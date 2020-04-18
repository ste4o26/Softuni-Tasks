package user_permissions.users;

import user_permissions.resources.Resource;

public interface User {
    void read(Resource resource);
}
