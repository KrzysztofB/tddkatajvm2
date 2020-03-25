package org.codingdojo.reversi

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object ReversiSpec : Spek ({
    describe("with simple kotlin spek test"){
        it("something should work"){
            assertThat(42).isEqualTo(42)
        }
    }
})