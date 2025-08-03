import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.ar.sceneform.ux.ArFragment
import com.google.vr.sdk.base.Viewport
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class OwhlBuildARespons(private val coroutineScope: CoroutineScope) {

    @Composable
    fun ARVRModuleMonitor(
        fragment: ArFragment,
        viewport: Viewport,
        onARSessionResume: () -> Unit,
        onARSessionPause: () -> Unit
    ) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("AR/VR Module Monitor")
                Spacer(Modifier.height(16.dp))

                // AR Session Controls
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max)
                ) {
                    Button(onClick = onARSessionResume) {
                        Text("Resume AR Session")
                    }
                    Button(onClick = onARSessionPause) {
                        Text("Pause AR Session")
                    }
                }

                Spacer(Modifier.height(16.dp))

                // AR Fragment
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) {
                    fragment
                }

                Spacer(Modifier.height(16.dp))

                // Viewport Controls
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max)
                ) {
                    Text("Viewport: ${viewport.width}x${viewport.height}")
                }
            }
        }
    }

    private fun Button(onClick: () -> Unit, content: @Composable () -> Unit) {
        Surface(
            modifier = Modifier
                .width(120.dp)
                .height(40.dp),
            elevation = 4.dp,
            color = MaterialTheme.colors.primary
        ) {
            content()
        }
    }
}