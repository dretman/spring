package com.dataart.retman;

import com.dataart.retman.beans.Performer;
import com.dataart.retman.beans.Poem;
import com.dataart.retman.beans.impl.PoeticJaggler;
import com.dataart.retman.beans.impl.Sonnet29;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdolConfig {

    @Bean
    public Poem sonnet29(){
        return new Sonnet29();
    }

    @Bean
    public Performer poeticDuke() {
        return new PoeticJaggler(18, sonnet29());
    }
}
