package com.galid.batch_study.conf

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["com.galid.batch_study.repository"])
class MongoConfig {

}