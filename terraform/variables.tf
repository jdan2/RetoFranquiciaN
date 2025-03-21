variable "vpc_id" {
  description = "ID de la VPC existente"
  type        = string
}

variable "subnet_ids" {
  description = "Lista de subnets existentes"
  type        = list(string)
}

variable "db_username" {
  description = "Usuario de la base de datos"
  type        = string
}

variable "db_password" {
  description = "Contraseña de la base de datos"
  type        = string
  sensitive   = true
}