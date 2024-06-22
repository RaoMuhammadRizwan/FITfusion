package com.example.fitfusion.com.example.fitfusion.Recipe

class RecipeCategoryAdapter(
    private val categories: List<RecipeCategory>,
    private val onClick: (RecipeCategory) -> Unit
) : RecyclerView.Adapter<RecipeCategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: ItemRecipeCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemRecipeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.textViewCategoryName.text = category.name
        holder.binding.root.setOnClickListener { onClick(category) }
    }

    override fun getItemCount() = categories.size
}
