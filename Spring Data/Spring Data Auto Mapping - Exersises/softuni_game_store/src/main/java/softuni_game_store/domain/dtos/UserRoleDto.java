package softuni_game_store.domain.dtos;

import softuni_game_store.domain.entities.Role;

public class UserRoleDto {
    private Role role;

    public UserRoleDto() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
