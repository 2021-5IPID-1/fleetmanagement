package be.ifosup.boilerplate.config.common.datatables;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataTable<T> {
    private int draw;
    private int start;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;

    public DataTable(List<T> data) {
        this.data = data;
    }
}
