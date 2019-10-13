import axios, { AxiosResponse } from "axios";
import ApiStatus from "@/model/ApiStatus";

const instance = axios.create({
  baseURL: "./api/v1"
});

export interface MQMApi {
  getStatus(): Promise<AxiosResponse<ApiStatus>>;
}

const apiObj: MQMApi = {
  getStatus(): Promise<AxiosResponse<ApiStatus>> {
    return instance.get<ApiStatus>("/status");
  }
};

export default apiObj;
