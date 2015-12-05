package com.chulabhornhospital.employee

import com.chulabhornhospital.employee.domain.Employee
import com.chulabhornhospital.employee.mapper.custom.EmployeeVersionMapper
import spock.lang.Specification

/**
 * Created by Administrator on 12/5/2015.
 */
class VersionSpec extends Specification {

    def "test getting version from table"() {
        given: "version mapper for query"
        def session = Main.factory.openSession()
        def mapper = session.getMapper(EmployeeVersionMapper.class)

        when: "get version of the record 1"
        Long version = mapper.getVersion(1L)

        then: "version should be 0"
        version == 0L

        cleanup:
        session.close()
    }

}
