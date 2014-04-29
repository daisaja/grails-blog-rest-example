package blog

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Post)
class PostSpec extends Specification {

    void "test something"() {
		when: Post post = new Post(author: 'lars', title: 'A great post about test!', text: 'something', created: new Date()).save()
		then: post.id 
    }
}
