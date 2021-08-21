package be.ifosup.boilerplate.config.common.datatables;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class DataTableBackToFrontConverter<T> {
    public DataTable<T> convert(Page page, int draw, int start) {
        DataTable dataTable = DataTable.builder()
                .data(page.getContent())
                .draw(draw)
                .start(start)
                .recordsFiltered(page.getTotalElements())
                .recordsTotal(page.getTotalElements())
                .build();

        return dataTable;
    }
}
