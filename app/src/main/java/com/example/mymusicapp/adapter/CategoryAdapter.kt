import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.CategoryItemsRecyclerRowBinding
import com.example.mymusicapp.models.CategaryModel
import com.example.mymusicapp.SongList

class CategoryAdapter(private val categoryList:List<CategaryModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding:CategoryItemsRecyclerRowBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bindData(category:CategaryModel){
                    binding.nameTextView.text=category.name
                    Glide.with(binding.coverImageView).load(category.coverUrl)
                    .apply(
                        RequestOptions().transform(RoundedCorners(32))
                    )
                        .into(binding.coverImageView)

                    //Start Song list Activity
                    val context=binding.root.context
                    binding.root.setOnClickListener{
                        SongList.category=category
                        context.startActivity(Intent(context, SongList::class.java))
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val binding = CategoryItemsRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}