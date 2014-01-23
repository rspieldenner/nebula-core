package nebula.core.tasks

import nebula.test.ProjectSpec

class UnzipProjectSpec extends ProjectSpec {
    def 'create task'() {
        when:
        def downloadTask = project.task([type:Download], 'download')
        def uploadTask = (Unzip) project.task([type:Unzip], 'unzip')
        uploadTask.from(downloadTask)

        then:
        uploadTask.inputs.hasInputs
        !uploadTask.outputs.files.isEmpty()
    }
}
