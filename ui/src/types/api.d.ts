import { MQMApi } from "@/api/api";

declare module "vue/types/vue" {
  interface Vue {
    $api: MQMApi;
  }
}
