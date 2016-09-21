package tk.jingood2.java.model;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class Type {

    private String typeId;
    private String name;
    private String desc;
    private String extension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {

        this.extension = extension;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
