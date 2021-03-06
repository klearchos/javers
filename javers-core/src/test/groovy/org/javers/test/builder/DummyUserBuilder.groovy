package org.javers.test.builder

import org.javers.core.model.DummyAddress
import org.javers.core.model.DummyUser
import org.joda.time.LocalDateTime

import static org.javers.test.builder.DummyUserDetailsBuilder.dummyUserDetails


/**
 * @author Pawel Cierpiatka <pawel.cierpiatka@gmail.com>
 */
class DummyUserBuilder {

    private DummyUser dummyUser

    static DummyUserBuilder dummyUser() {
        new DummyUserBuilder().withName("dummyUser")
    }

    static DummyUserBuilder dummyUser(String name) {
        new DummyUserBuilder().withName(name)
    }

    DummyUserBuilder() {
        dummyUser = new DummyUser()
    }

    DummyUser build() {
        if (dummyUser.name == null) {
            dummyUser.name = "some"
        }
        dummyUser
    }

    DummyUserBuilder withName(String name) {
        dummyUser.name = name
        this
    }

    DummyUserBuilder withInteger(Integer largeInt) {
        dummyUser.largeInt = largeInt
        this
    }

    DummyUserBuilder withSex(DummyUser.Sex sex) {
        dummyUser.sex = sex
        this
    }

    DummyUserBuilder withSupervisor(String supervisorName) {
        dummyUser.supervisor = new DummyUser(supervisorName)
        this
    }

    DummyUserBuilder withSupervisor(DummyUser supervisor) {
        dummyUser.supervisor = supervisor
        this
    }


    DummyUserBuilder withDetails() {
        dummyUser.dummyUserDetails = dummyUserDetails().withId(1).build()
        this
    }

    DummyUserBuilder withDetails(long id) {
        dummyUser.dummyUserDetails = dummyUserDetails().withId(id).build()
        this
    }

    DummyUserBuilder withAddress(String city) {
        if (dummyUser.dummyUserDetails == null) {
            withDetails()
        }
        dummyUser.dummyUserDetails.dummyAddress = new DummyAddress(city)
        this
    }

    DummyUserBuilder withAddresses(DummyAddress... addresses) {
        dummyUser.dummyUserDetails.addressList = addresses.toList()
        this
    }


    DummyUserBuilder withDetailsList(int numberOfDetailsInList) {
        dummyUser.dummyUserDetailsList = (1 .. numberOfDetailsInList).collect({ dummyUserDetails().withId(it).build() })
        this
    }

    DummyUserBuilder withEmployees(int numberOfEmployees) {
        for (i in 1 .. numberOfEmployees) {
            dummyUser.addEmployee(new DummyUser("Em" + i))
        }
        this
    }

    DummyUserBuilder withEmployee(DummyUser rob) {
        dummyUser.addEmployee(rob)
        this
    }

    DummyUserBuilder withFlag(boolean flag) {
        dummyUser.flag = flag
        this
    }

    DummyUserBuilder withValueMap(Map map) {
        dummyUser.valueMap = map
        this
    }

    DummyUserBuilder withPrimitiveMap(Map map) {
        dummyUser.primitiveMap = map
        this
    }

    DummyUserBuilder withBoxedFlag(Boolean boxedFlag) {
        dummyUser.bigFlag = boxedFlag
        this
    }

    DummyUserBuilder withAge(int age) {
        dummyUser.age = age
        this
    }

    DummyUserBuilder withStringsSet(String... strings) {
        dummyUser.stringSet = strings as Set
        this
    }

    DummyUserBuilder withStringsSet(Set<String> strings) {
        dummyUser.stringSet = strings
        this
    }

    DummyUserBuilder withIntegerList(Integer... integers) {
        dummyUser.integerList = integers as List
        this
    }

    DummyUserBuilder withIntegerList(List<Integer> integers) {
        dummyUser.integerList = integers
        this
    }

    DummyUserBuilder withIntArray(int... integers) {
        dummyUser.intArray = integers
        this
    }

    DummyUserBuilder withCharacter(char _char) {
        dummyUser._char = _char
        this
    }

    DummyUserBuilder withDateTimeArray(int count) {
        dummyUser.dateTimes = new LocalDateTime[count];
        for (int i=0; i<count; i++) {
            dummyUser.dateTimes[i] = new LocalDateTime();
        }
        this
    }
}
