package com.example.fitfusion.com.example.fitfusion.Recipe

class MealRecipeAdapter(
    private val recipes: List<MealRecipe>,
    private val onClick: (MealRecipe) -> Unit
) : RecyclerView.Adapter<MealRecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: ItemMealRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemMealRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.binding.textViewRecipeTitle.text = recipe.title
        holder.binding.root.setOnClickListener { onClick(recipe) }
    }

    override fun getItemCount() = recipes.size
}
