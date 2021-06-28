package com.example.furniturear.helpers

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.furniturear.R
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    lateinit var arrayView: Array<View>
    lateinit var arFragment: ArFragment
    lateinit var bedRenderable: ModelRenderable
    lateinit var chairRenderable: ModelRenderable
    lateinit var deskRenderable: ModelRenderable
    lateinit var diningTableRenderable: ModelRenderable
    lateinit var drawerRenderable: ModelRenderable
    lateinit var sofaRenderable: ModelRenderable
    internal var selected = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupArray()
        setupClickListener()
        loadModel()

        arFragment = childFragmentManager.findFragmentById(R.id.scene_form_fragment) as ArFragment
        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
            val anchorNode = AnchorNode(
                hitResult.createAnchor()
            )

            anchorNode.setParent(arFragment.arSceneView.scene)
            val bed = Node()
            bed.renderable = bedRenderable
            bed.setParent(anchorNode)
        }

    }

    private fun loadModel() {
        ModelRenderable.builder()
            .setSource(
                context,
                Uri.parse("bed.sfb")
            )
            .build()
            .thenAccept { bedRenderable = it }

        ModelRenderable.builder()
            .setSource(
                context,
                Uri.parse("chair.sfb")
            )
            .build()
            .thenAccept { chairRenderable = it }

        ModelRenderable.builder()
            .setSource(
                context,
                Uri.parse("desk.sfb")
            )
            .build()
            .thenAccept { deskRenderable = it }

        ModelRenderable.builder()
            .setSource(
                context,
                Uri.parse("diningTable.sfb")
            )
            .build()
            .thenAccept { diningTableRenderable = it }

        ModelRenderable.builder()
            .setSource(
                context,
                Uri.parse("drawer.sfb")
            )
            .build()
            .thenAccept { drawerRenderable = it }

        ModelRenderable.builder()
            .setSource(
                context,
                Uri.parse("sofa.sfb")
            )
            .build()
            .thenAccept { sofaRenderable = it }



    }

    private fun setupClickListener() {
        for (i in arrayView.indices) {
            arrayView[i].setOnClickListener(this)
        }
    }

    private fun setupArray() {
        arrayView = arrayOf(
            bed,
            chair,
            desk,
            diningTable,
            drawer,
            sofa
        )
    }

    override fun onClick(view: View?) {

    }
}