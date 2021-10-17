package Server;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "mark_table")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mark_id")
    private Integer mark_id;

    @Column(name = "mark")
    private String mark;

    public Mark(String mark) {
        this.mark = mark;
    }

    public Mark(){}

    public Integer getMark_id() {
        return mark_id;
    }

    public void setMark_id(Integer mark_id) {
        this.mark_id = mark_id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return Objects.equals(mark, mark1.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mark{");
        sb.append("mark_id=").append(mark_id);
        sb.append(", mark='").append(mark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
