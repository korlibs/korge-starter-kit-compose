import androidx.compose.runtime.*
import korlibs.event.*
import korlibs.image.color.*
import korlibs.korge.*
import korlibs.korge.compose.*
import korlibs.korge.scene.*
import korlibs.korge.view.*
import korlibs.math.geom.*
import korlibs.math.geom.Anchor

suspend fun main() = Korge(
    title = "Korge Compose",
    windowSize = Size(512, 512),
    backgroundColor = Colors["#2b2b2b"],
    displayMode = KorgeDisplayMode(ScaleMode.SHOW_ALL, Anchor.TOP_LEFT, clipBorders = false),
) {
    val sceneContainer = sceneContainer()

    sceneContainer.changeTo({ MyScene() })
}

class MyScene : Scene() {
    override suspend fun SContainer.sceneMain() {
        setComposeContent(this) {
            var width by remember { mutableStateOf(width.toInt()) }
            var height by remember { mutableStateOf(height.toInt()) }
            LaunchedEffect(true) {
                fun onResized() {
                    val w = views.actualVirtualWidth
                    val h = views.actualVirtualHeight
                    width = w
                    height = h
                    this@sceneMain.size(w.toDouble(), h.toDouble())
                }

                onEvent(ReshapeEvent) {
                    onResized()
                }
                onResized()
                //onStageResized { w, h ->
                //    //println("RESIZED: $w, $h")
                //    this@sceneMain.size(w.toDouble(), h.toDouble())
                //}
            }
            MainApp(width, height)
        }
    }
}

@Composable
private fun MainApp(width: Int, height: Int) {
    var color by remember { mutableStateOf(Colors.WHITE) }
    var count by remember { mutableStateOf(0) }

    fun insert(digit: Int) {
        count *= 10
        count += digit
    }

    VStack(width.toFloat(), adjustSize = true) {
        Text("$count", color)
        HStack {
            Button("-") { count-- }
            Button("+") { count++ }
        }
    }
}
