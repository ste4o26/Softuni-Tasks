package product_shop.domain.dtos.export;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserProductViewDto {
    @Expose
    private Integer userCount;

    @Expose
    private List<UserDetailViewDto> users;

    public UserProductViewDto() {
    }

    public UserProductViewDto(Integer userCount, List<UserDetailViewDto> users) {
        this.userCount = userCount;
        this.users = users;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public List<UserDetailViewDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDetailViewDto> users) {
        this.users = users;
    }
}
