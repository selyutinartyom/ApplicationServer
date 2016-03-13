package org.demo.server.config

import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.io.IOException
import java.io.InputStream
import java.util.*
import javax.annotation.Resource
import javax.sql.DataSource

/**
 * Конфигурация БД
 *
 * @author Secundus
 * @since 13.03.2016 0:29
 */
@Configuration
@EnableJpaRepositories(basePackages = arrayOf("org.demo.server.repository"))
@EnableTransactionManagement
@ComponentScan(basePackages = arrayOf("org.demo.server"))
@PropertySource("classpath:db.properties")
open class DatabaseConfig {

    @Resource
    var env: Environment? = null

    @Bean
    open fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSource()
        em.setPackagesToScan(env?.getRequiredProperty("db.entity.package"))
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()
        em.setJpaProperties(getHibernateProperties())

        return em
    }

    @Bean
    open fun dataSource(): DataSource? {
        val ds = BasicDataSource()
        ds.driverClassName = env?.getRequiredProperty("db.driver")
        ds.url = env?.getRequiredProperty("db.url")
        ds.username = env?.getRequiredProperty("db.username")
        ds.password = env?.getRequiredProperty("db.password")

        // Database connection pool configuration
        ds.initialSize = Integer.valueOf(env?.getRequiredProperty("db.initialSize"))
        ds.minIdle = Integer.valueOf(env?.getRequiredProperty("db.minIdle"))
        ds.maxIdle = Integer.valueOf(env?.getRequiredProperty("db.maxIdle"))
        ds.timeBetweenEvictionRunsMillis = java.lang.Long.valueOf(
                env?.getRequiredProperty("db.timeBetweenEvictionRunsMillis"))
        ds.minEvictableIdleTimeMillis = java.lang.Long.valueOf(
                env?.getRequiredProperty("db.minEvictableIdleTimeMillis"))
        ds.testOnBorrow = java.lang.Boolean.valueOf(env?.getRequiredProperty("db.testOnBorrow"))
        ds.validationQuery = env?.getRequiredProperty("db.validationQuery")

        return ds
    }

    @Bean
    open fun transactionManager(): PlatformTransactionManager {
        val manager = JpaTransactionManager()
        manager.entityManagerFactory = entityManagerFactory().`object`

        return manager
    }

    private fun getHibernateProperties(): Properties? {
        val properties = Properties()
        val inputStream: InputStream = javaClass.classLoader.getResourceAsStream("hibernate.properties")
        try {
            properties.load(inputStream)
            return properties
        } catch (e: IOException) {
            throw IllegalArgumentException("Can't find 'hibernate.properties' in classpath!", e)
        }
    }
}