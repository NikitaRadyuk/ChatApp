package by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity;


/**
 * Перечисляемый тип, описывающий роль пользователя(Администратор/пользователь)
 */
public enum Role {
    ADMIN(0),
    USER(1);

    private final int roleId;

    Role(){
        roleId = 1;
    }
    Role(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public static Role getValueOf(String name){
        if(name == "ADMIN"){
            return ADMIN;
        }else{
            return USER;
        }
    }
}
