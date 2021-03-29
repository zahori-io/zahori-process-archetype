#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.zahori.framework.core.BaseProcess;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ZahoriProcessApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZahoriProcessApp.class)
            .properties(BaseProcess.getProperties())
            .build()
            .run(args);
    }

}
