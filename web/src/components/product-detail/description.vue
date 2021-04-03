<template>
  <div class="col-md-12 col-lg-12">
    <div class="row">
      {{ productDescription }}
    </div>
    <hr>
  </div>
</template>

<script>
export default {
  name: "description",
  props: ['productDescription']
}
</script>

<style scoped>

</style>
