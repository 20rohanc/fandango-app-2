package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theaters", catalog = "Fandango")
public class Theater {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "company")
    private String name;

    public Theater() {
    }

    public Theater(Integer id2, String name2) {
    	id = id2;
    	name = name2;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
