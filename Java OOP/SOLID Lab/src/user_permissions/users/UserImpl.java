package user_permissions.users;

import user_permissions.resources.Resource;

public abstract class UserImpl implements User{

    @Override
    public void read(Resource resource) {
        String result = String.format(this.toString() +
                resource.getClass().getSimpleName() +
                resource.toString());

        System.out.println(result);
    }

    @Override
    public String toString() {
        return String.format("%s read successfully ",
                this.getClass().getSimpleName());
    }
}
