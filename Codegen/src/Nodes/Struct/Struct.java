package Nodes.Struct;

import java.util.List;

public class Struct {
    private String name;
    private List<StructContent> contents;

    public Struct( String name) {
        this.name = name;
        StructHandler.structHandler.addtoStructs(this);
        StructHandler.structHandler.setCurrent(this);
    }

    public String getName() {
        return name;
    }

    public void addContent(StructContent content){
        this.contents.add(content);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StructContent> getContents() {
        return contents;
    }


}
