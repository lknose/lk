package cn.itcast.model;

public class Role {
    Long id;
    String creator;
    String description;
    String role_name;
    Integer role_type;

    public Role() {
    }

    public Role(Long id, String creator, String description, String role_name, Integer role_type) {
        this.id = id;
        this.creator = creator;
        this.description = description;
        this.role_name = role_name;
        this.role_type = role_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getRole_type() {
        return role_type;
    }

    public void setRole_type(Integer role_type) {
        this.role_type = role_type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", description='" + description + '\'' +
                ", role_name='" + role_name + '\'' +
                ", role_type=" + role_type +
                '}';
    }
}
