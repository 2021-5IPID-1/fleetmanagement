package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_1_1__AddEmailOnDefaultUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        Statement statement = context.getConnection().createStatement();
        statement.execute("UPDATE users SET emailaddress='admin@admin.be' WHERE username='admin'");
        statement.execute("UPDATE users SET emailaddress='user@user.be' WHERE username='user'");

    }
}
