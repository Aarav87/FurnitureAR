package com.example.furniturear.helpers

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.furniturear.R
import com.google.ar.sceneform.rendering.ModelRenderable
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    lateinit var arrayView: Array<View>
    lateinit var bedRenderable: ModelRenderable
    lateinit var chairRenderable: ModelRenderable
    lateinit var deskRenderable: ModelRenderable
    lateinit var diningTableRenderable: ModelRenderable
    lateinit var drawerRenderable: ModelRenderable
    lateinit var sofaRenderable: ModelRenderable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupArray()
        setupClickListener()
        loadModel()

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